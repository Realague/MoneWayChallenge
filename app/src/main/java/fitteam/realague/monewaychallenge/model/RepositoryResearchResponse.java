package fitteam.realague.monewaychallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepositoryResearchResponse {

    @SerializedName("items")
    private List<Repository> repositories;

    public RepositoryResearchResponse(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }
}
