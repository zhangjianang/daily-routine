package es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ang on 2018/8/26.
 */
public class EmployeeSearch {
    @SuppressWarnings({ "unchecked", "resource" })
    public static void main(String[] args) throws IOException {
        Settings settings = Settings.builder()
                .put("cluster.name","elasticsearch")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));
        prepareData(client);
        executeSearch(client);
        client.close();
    }

    private static void executeSearch(TransportClient client) {
        SearchResponse response = client.prepareSearch("company")
                .setTypes("employee")
                .setQuery(QueryBuilders.matchQuery("postion", "technique"))
                .setPostFilter(QueryBuilders.rangeQuery("age").from(20).to(40))
                .setFrom(0)
                .setSize(1)
                .get();
        System.out.println();
        SearchHit[] hits = response.getHits().getHits();
        for(int i=0 ;i < hits.length;i++){
            System.out.println(hits[i].getSourceAsString());
        }

    }

    private static void prepareData(TransportClient client) throws IOException {
        IndexResponse response = client.prepareIndex("company", "employee", "1")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "jack")
                        .field("age", 27)
                        .field("position", "technique")
                        .field("country", "china")
                        .field("join date", "20180102")
                        .field("salary", 1000)
                        .endObject())
                .get();
        System.out.println(response.getResult());

        client.prepareIndex("company", "employee", "2")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "ang")
                        .field("age", 30)
                        .field("position", "technique")
                        .field("country", "china")
                        .field("join date", "20180103")
                        .field("salary", 2000)
                        .endObject())
                .get();
        client.prepareIndex("company", "employee", "3")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "feng")
                        .field("age", 37)
                        .field("position", "technique")
                        .field("country", "china")
                        .field("join date", "20180102")
                        .field("salary", 10000)
                        .endObject())
                .get();
        client.prepareIndex("company", "employee", "4")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "xian")
                        .field("age", 17)
                        .field("position", "pm")
                        .field("country", "franch")
                        .field("join date", "20180112")
                        .field("salary", 4000)
                        .endObject())
                .get();
        client.prepareIndex("company", "employee", "1")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "jack")
                        .field("age", 27)
                        .field("position", "technique")
                        .field("country", "china")
                        .field("join date", "20180102")
                        .field("salary", 1000)
                        .endObject())
                .get();
    }
}
