package nasa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class DataFetcher {
    public String key = "api_key=VHdG74iewJt6gyGwpbRICNAoAKGTFjbpH9JqMNJB";
    public String protocol = "https";
    public String authority = "api.nasa.gov";
    public String services = "/neo/rest/v1/neo/browse";
    public static ObjectMapper reader = new ObjectMapper();

    public DataFetcher() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        reader.registerModule(module);
    }

    public Document fetch(int page) throws IOException, URISyntaxException {
        String query = prepareQuery(page);
        URI uri = prepareURI(query);
        URL url = uri.toURL();
        //return Document.
        return reader.readValue(url, Document.class);
    }

    public String prepareQuery(int index) {
        return (key + "&page=" + String.valueOf(index));
    }

    private URI prepareURI(String query) throws URISyntaxException {
        return new URI(protocol, authority, services, query, null);
    }

    public List<NearEarthObject> fetchPages(int nbPages) throws IOException, URISyntaxException {
        List<NearEarthObject> near = new ArrayList<>();
        for(int i = 0; i<= nbPages; i++) {
            near.addAll(fetch(i).getNearEarthObjects());
            //TODO A TJRS LES LES MEME DONNES
        }
        return near;
    }

    public String drawPages(int nbPages) throws IOException, URISyntaxException {
        String name = "";
        List<NearEarthObject> near = fetchPages(nbPages);
        for(NearEarthObject nears : near) {
            name += nears.getName() + "\n";
        }
        return name;
    }

    public void fetchToOutputStream(int page, OutputStream outputStream) throws URISyntaxException, IOException {
        String query = prepareQuery(page);
        URI uri = prepareURI(query);
        URL url = uri.toURL();
        System.out.println(uri.toURL());
        InputStream inputStream = url.openStream();
        inputStream.transferTo(outputStream);
    }

    public TreeMap<Integer, Integer> getData(int pages) throws IOException, URISyntaxException {
        TreeMap<Integer, Integer> approach = new TreeMap<>();
        List<Integer> year = new ArrayList<>();
        final ObjectMapper mapper = new ObjectMapper();
        DataFetcher dataFetcher = new DataFetcher();
        List<NearEarthObject> nearEarth = dataFetcher.fetchPages(pages);// getNearEarthObjects();

        int next = 0;
        for (int i = 0; i < nearEarth.size(); i++) {
            if (nearEarth.get(i).getCloseApproachData().size() > 0) {
                LocalDate toAdd = nearEarth.get(i).getCloseApproachData().get(0).getCloseApproachDate();
                year.add(toAdd.getYear());
                if (approach.containsKey(toAdd.getYear())) {
                    next = approach.get(toAdd.getYear()) + 1;
                } else {
                    next = 1;
                }
                approach.put(toAdd.getYear(), next);
            }
        }
        return approach;
    }
}
