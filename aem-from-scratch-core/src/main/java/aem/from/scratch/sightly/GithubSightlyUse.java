package aem.from.scratch.sightly;

import java.util.ArrayList;
import java.util.List;

public class GithubSightlyUse {

    public List<String> getRepositories() {
        List<String> githubRepositories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            githubRepositories.add("Repo:" + i);
        }
        return githubRepositories;
    }

}
