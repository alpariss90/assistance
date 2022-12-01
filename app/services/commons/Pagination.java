package commons;

import java.util.List;

public class Pagination<T> {
    private final int pageSize;
    private final long totalRowCount;
    private final int pageIndex;
    private final List<T> list;

    public Pagination(List<T> data, long total, int page, int pageSize) {
        if (page < 1) {
            page = 1;
        }

        this.list = data;
        this.totalRowCount = total;
        this.pageIndex = page;
        this.pageSize = pageSize;
    }

    public long getTotalRowCount() {
        return this.totalRowCount;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public List<T> getList() {
        return this.list;
    }

    public boolean hasPrev() {
        return this.pageIndex > 1;
    }

    public boolean hasNext() {
        return (this.totalRowCount / (long) this.pageSize) >= (long) this.pageIndex;
    }

    public String getDisplayXtoYofZ() {
        int start = (this.pageIndex - 1) * this.pageSize + 1;
        int end = start + Math.min(this.pageSize, this.list.size()) - 1;
        return start + " to " + end + " of " + this.totalRowCount;
    }
}