package aem.from.scratch.sightly.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.osgi.service.component.annotations.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import aem.from.scratch.sightly.IGithubRepoFetcher;

@Component(immediate = true, service = IGithubRepoFetcher.class)
public class GithubRepoFetcher implements IGithubRepoFetcher {

    public List<String> getRepositories() {
        List<String> repositoriesList = new ArrayList<>();
        try {
            InputStream streamFromGithub = getResponseStreamFromGithub();
            JsonElement jsonElement = parseStreamToJson(streamFromGithub);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                JsonElement name = jsonObject.get("name");
                repositoriesList.add(name.getAsString());
            }
        } catch (Exception e) {
            // HANDLE EXCEPTION HERE
        }
        return repositoriesList;
    }

    private JsonElement parseStreamToJson(InputStream stream) {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new InputStreamReader(stream));
        return jsonElement;
    }

    private InputStream getResponseStreamFromGithub() throws IOException {
        Random random = new Random();
        int randomInt = random.nextInt(150000);
        String url = "https://api.github.com/repositories?since=" + randomInt;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        InputStream inputStream = con.getInputStream();
        return inputStream;
    }
}
