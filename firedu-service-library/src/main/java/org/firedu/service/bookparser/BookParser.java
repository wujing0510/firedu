package org.firedu.service.bookparser;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.firedu.entity.Article;
import org.firedu.entity.Book;
import org.firedu.entity.Chapter;
import org.firedu.entity.Section;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO
 *
 * @author Wu Jing
 * @date 2017-08-10 22:40:41
 */
public class BookParser {

    public Book doParse(String filePath) {
        File contentFile = new File(filePath + "/" + "content.opf");
        if (!contentFile.exists()) {
            return new Book();
        }

        Book book = doParseContentFile(contentFile);

        File tocFile = new File(filePath + "/" + "toc.ncx");
        doParseTocFile(tocFile, book);

        doParseChapters(book, filePath + "/");

        return book;
    }

    public void doParseChapters(Book book, String filePath) {

        if (book.getChapters() != null && book.getChapters().size() > 0) {
            for (Chapter chapter : book.getChapters()) {
                doParseChapter(chapter, filePath);
            }
        }

    }

    public void doParseChapter(Chapter chapter, String filePath) {
        System.out.println(chapter);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(filePath + "" + chapter.getDescription()));
            Element root = document.getRootElement();
            Element body = root.element("body");
            if (body != null) {
                Element div = body.element("div");
                List<Element> ps = div.elements("p");

                List<Article> articles = new ArrayList<Article>();
                chapter.setArticles(articles);
                Article currentArticle = null;
                int articleNumber = 0;
                int sectionNumber = 0;
                for (Element p : ps) {
                    if ("calibre5".equals(p.attributeValue("class"))) {
                        String content = p.getTextTrim();
                        if (content.length() < 15) {
                            currentArticle = new Article();
                            currentArticle.setChapter(chapter);
                            currentArticle.setOrder_num(++articleNumber);
                            currentArticle.setTitle(content);
                            currentArticle.setBook(chapter.getBook());
                            currentArticle.setSections(new ArrayList<Section>());
                            articles.add(currentArticle);
                            sectionNumber = 0;
                        } else if (currentArticle != null) {
                            Section section = new Section();
                            section.setArticle(currentArticle);
                            section.setContent(content);
                            section.setOrder_num(++sectionNumber);
                            currentArticle.getSections().add(section);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doParseTocFile(File tocFile, Book book) {
        List<Chapter> chapters = new ArrayList<Chapter>();
        book.setChapters(chapters);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(tocFile);
            Element root = document.getRootElement();
            Element navMap = root.element("navMap");
            if (navMap != null) {
                List navPoints = navMap.elements("navPoint");
                int num = 0;
                for (Iterator<Element> it = navPoints.iterator(); it.hasNext(); ) {
                    Element navPoint = it.next();
                    String text = navPoint.element("navLabel").element("text").getTextTrim();
                    String content = navPoint.element("content").attributeValue("src");
                    if (content != null && content.contains("#")) {
                        content = content.substring(0, content.indexOf("#"));
                    }
                    //String clazz = navPoint.attributeValue("class");
                    //String playOrder = navPoint.attributeValue("playOrder");
                    //System.out.println("  " + text + " " + content + " " + playOrder);

                    if ("封面".equals(text) || "版权页".equals(text)) {
                        continue;
                    }

                    Chapter chapter = new Chapter();
                    chapter.setOrder_num(++num);
                    chapter.setTitle(text);
                    chapter.setDescription(content);
                    chapter.setBook(book);

                    chapters.add(chapter);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book doParseContentFile(File contentFile) {
        Book book = new Book();
        book.setSubject1("经部");
        book.setSubject2("十三经");

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(contentFile);
            Element root = document.getRootElement();
            for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ) {
                Element element = it.next();
                if ("metadata".equals(element.getName())) {
                    //System.out.println("metadata");

                    for (Iterator<Element> it2 = element.elementIterator(); it2.hasNext(); ) {
                        Element element2 = it2.next();
                        //System.out.println("  " + element2.getName());
                        if ("description".equals(element2.getName())) {
                            String description = element2.getTextTrim();
                            book.setDescription(description);
                            //System.out.println("    " + description);
                        } else if ("date".equals(element2.getName())) {
                            String date = element2.getTextTrim();
                            if (date != null && date.length() > 19) {
                                date = date.substring(0, 19);
                                date = date.replaceAll("T", " ");
                            }
                            book.setDatetime(date);
                            //System.out.println("    " + date);
                        } else if ("meta".equals(element2.getName())) {
                            String name = element2.attributeValue("name");
                            String content = element2.attributeValue("content");
                            if ("calibre:title_sort".equals(name)) {
                                //System.out.println("    title: " + content);
                            } else if ("calibre:timestamp".equals(name)) {
                                //System.out.println("    timestamp: " + content);
                            } else if ("cover".equals(name)) {
                                //System.out.println("    cover: " + content);
                            } else if ("primary-writing-mode".equals(name)) {
                                //System.out.println("    cover: " + content);
                            }
                        } else if ("creator".equals(element2.getName())) {
                            String creator = element2.getTextTrim();
                            book.setAuthor(creator);
                            //System.out.println("    " + creator);
                        } else if ("title".equals(element2.getName())) {
                            String title = element2.getTextTrim();
                            book.setTitle(title);
                            //System.out.println("    " + title);
                        } else if ("contributor".equals(element2.getName())) {
                            String contributor = element2.getTextTrim();
                            //System.out.println("    " + contributor);
                        } else if ("language".equals(element2.getName())) {
                            String language = element2.getTextTrim();
                            book.setLanguage(language);
                            //System.out.println("    " + language);
                        } else if ("identifier".equals(element2.getName())) {
                            String scheme = element2.attributeValue("scheme");
                            String content = element2.getTextTrim();
                            if ("MOBI-ASIN".equals(scheme)) {
                                book.setAsin(content);
                                //System.out.println("    MOBI-ASIN: " + content);
                            } else if ("uuid".equals(scheme)) {
                                book.setUuid(content);
                                //System.out.println("    uuid: " + content);
                            } else if ("calibre".equals(scheme)) {
                                //System.out.println("    calibre: " + content);
                            }
                        }
                    }

                } else if ("manifest".equals(element.getName())) {
                    //System.out.println("manifest");
                    for (Iterator<Element> it2 = element.elementIterator(); it2.hasNext(); ) {
                        Element element2 = it2.next();
                        String mediaType = element2.attributeValue("media-type");
                        String id = element2.attributeValue("id");
                        String href = element2.attributeValue("href");
                        //System.out.println("  " + element2.getName());
                        //System.out.println("    " + id + " " + href);
                    }
                } else if ("spine".equals(element.getName())) {
                    //System.out.println("spine");
                    for (Iterator<Element> it2 = element.elementIterator(); it2.hasNext(); ) {
                        Element element2 = it2.next();
                        String idref = element2.attributeValue("idref");
                        //System.out.println("  " + element2.getName());
                        //System.out.println("    idref: " + idref);
                    }
                } else if ("guide".equals(element.getName())) {
                    //System.out.println("guide");
                    for (Iterator<Element> it2 = element.elementIterator(); it2.hasNext(); ) {
                        Element element2 = it2.next();
                        String title = element2.attributeValue("title");
                        String type = element2.attributeValue("type");
                        String href = element2.attributeValue("href");
                        if (href != null && href.contains("#")) {
                            href = href.substring(0, href.indexOf("#"));
                        }
                        //System.out.println("  " + element2.getName());
                        //System.out.println("    " + title + " " + type + " " + href);
                    }
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        String coverPath = contentFile.getParent() + "/cover.jpeg";
        book.setCover(coverPath);

        return book;
    }

}
