package com.blue.fish.search.word.segmentation;

import com.hankcs.lucene.HanLPAnalyzer;
import com.mysql.jdbc.Driver;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bluefish 2019-06-25
 * @version 1.0.0
 */
public class WordSegmentCreateDemo {

    public static void main(String[] args) throws Exception {
        // 创建存储目录
        Directory directory = FSDirectory.open(new File("/Users/bluefish/Documents/workspace/base/java-code/temp/wordIndex").toPath());
        // 创建中文分词分析器
        Analyzer analyzer = new HanLPAnalyzer();
        // 创建索引配置对象
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        // 创建索引写入器
        IndexWriter writer = new IndexWriter(directory, config);

        List<Document> documents = queryFromDatabase();

        for (Document document : documents) {
            writer.addDocument(document);
        }

        writer.close();
    }

    private static List<Document> queryFromDatabase() throws Exception {
        DriverManager.registerDriver(new Driver());

        String url = "jdbc:mysql://localhost:3306/ntail?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        String userName = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, userName, password);

        String sql = "select id,title from t_sku ";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();
        List<Document> documents = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String title = resultSet.getString("title");

            Document document = new Document();
            document.add(new TextField("id", id, Field.Store.YES));
            document.add(new TextField("title", title, Field.Store.YES));

            documents.add(document);
        }

        connection.close();

        return documents;
    }
}
