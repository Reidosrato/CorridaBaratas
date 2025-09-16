package corridabaratas.corridabaratas.dto.response;

import java.util.List;

public class PaginacaoDTOResponse<T> {
    private List<T> data;
    private PaginacaoInfoDTO pagination;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PaginacaoInfoDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginacaoInfoDTO pagination) {
        this.pagination = pagination;
    }

    public static class PaginacaoInfoDTO {
        private Integer page;
        private Integer limit;
        private Integer total;
        private Integer pages;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }
    }
}
