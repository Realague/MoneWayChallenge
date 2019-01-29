package fitteam.realague.monewaychallenge.model;

import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("full_name")
    private String fullName;

    private String description;

    @SerializedName("stargazers_count")
    private int stars;

    private String language;

    @SerializedName("branches_url")
    private String branchesUrl;

    @SerializedName("contributors_url")
    private String contributorsUrl;

    public Repository(String fullName,
                      String description,
                      int stars,
                      String language,
                      String branchesUrl,
                      String contributorsUrl) {
        this.fullName = fullName;
        this.description = description;
        this.stars = stars;
        this.language = language;
        this.branchesUrl = branchesUrl;
        this.contributorsUrl = contributorsUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getStars() {
        return String.valueOf(stars);
    }

    public String getLanguage() {
        return language;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

}
