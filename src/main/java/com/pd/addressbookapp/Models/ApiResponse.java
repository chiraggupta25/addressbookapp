package com.pd.addressbookapp.Models;

import java.util.List;

public class ApiResponse {
    private List<User> users;

    private int total;
    private int offset;
    private int limit;
    private boolean more;
    private String query;

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }
    public int getOffset() { return offset; }
    public void setOffset(int offset) { this.offset = offset; }
    public int getLimit() { return limit; }
    public void setLimit(int limit) { this.limit = limit; }
    public boolean isMore() { return more; }
    public void setMore(boolean more) { this.more = more; }
    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }
}
