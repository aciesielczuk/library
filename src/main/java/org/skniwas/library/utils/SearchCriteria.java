package org.skniwas.library.utils;


import org.springframework.stereotype.Component;
import javax.validation.constraints.NotBlank;

@Component
public class SearchCriteria {
    @NotBlank
    private String query;
    private String searchBy;

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public SearchCriteria() {
    }

    public SearchCriteria(String query, String searchBy) {
        this.query = query;
        this.searchBy = searchBy;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
