package aem.from.scratch.sightly;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class GithubSightlyUse {

    @Reference
    private IGithubRepoFetcher repoFetcher;

    public List<String> getRepositories() {
        List<String> githubRepositories = repoFetcher.getRepositories();
        return githubRepositories;
    }

}
