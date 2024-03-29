package kr.or.ddit.common.paging;

public interface PaginationRenderer {
	/**
	 * PaginationInfo의 startPage에서 endPage 까지 데이터로 페이지 이동 링크를 동적 생성.
	 * @param paging
	 * @return
	 */
	public String renderPagination(PaginationInfo paging);
}
