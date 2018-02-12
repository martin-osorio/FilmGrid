package com.example.martinosorio.filmgrid.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Films {

    @SerializedName("film")
    private List<Film> films = null;

    @SerializedName("total")
    private Integer total;

    @SerializedName("previosOffset")
    private Object previosOffset;

    @SerializedName("nextOffset")
    private Integer nextOffset;

    @SerializedName("pageIndex")
    private Integer pageIndex;

    @SerializedName("pageTotal")
    private Integer pageTotal;

    @SerializedName("id")
    private Object id;

    @SerializedName("title")
    private Object title;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getPreviosOffset() {
        return previosOffset;
    }

    public void setPreviosOffset(Object previosOffset) {
        this.previosOffset = previosOffset;
    }

    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }
}
