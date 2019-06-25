package com.blue.fish.search.word.segmentation;

import com.hankcs.lucene.HanLPAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;


/**
 * @author bluefish 2019-06-25
 * @version 1.0.0
 */
public class QueryFromWordSegment {

    public static void main(String[] args) throws Exception {
        // 打开索引目录
        Directory directory = FSDirectory.open(Paths.get("/Users/bluefish/Documents/workspace/base/java-code/temp/wordIndex"));

        // 索引阅读器
        IndexReader reader = DirectoryReader.open(directory);

        // 索引扫描器
        IndexSearcher searcher = new IndexSearcher(reader);

        // 需要搜索的内容
        String text = "我想要苹果手机";

        // 搜索字段的名称
        String field = "title";

        Analyzer analyzer = new HanLPAnalyzer();

        QueryParser queryParser = new QueryParser(field, analyzer);

        Query query = queryParser.parse(text);

        TopDocs topDocs = searcher.search(query, 100);

        System.out.println("命中的记录数：" + topDocs.totalHits);

        ScoreDoc[] docs = topDocs.scoreDocs;

        for (ScoreDoc doc : docs) {
            Document document = searcher.doc(doc.doc);
            String id = document.get("id");
            String title = document.get("title");
            System.out.println("id ->" + id);
            System.out.println("title ->" + title);
        }

        reader.close();

    }
}
