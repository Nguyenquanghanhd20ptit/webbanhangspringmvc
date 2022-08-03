package laptrinh.Servicer.impl;

import org.springframework.stereotype.Service;

import laptrinh.modell.paginates;
import laptrinh.service.Paginates_interface;

@Service
public class paginateService implements Paginates_interface {
	public paginates getInfoPaginates(int totalData,int limit,int curentPage) {
		paginates paginates = new paginates();
		paginates.setTotalPage(totalData);
		paginates.setLimit(limit);
		int totalPage=0;
		if(totalData%limit==0) {
			totalPage=totalData/limit;
		}
		else totalPage=totalData/limit+1;
		paginates.setTotalPage(totalPage);
		
		if(curentPage<1) curentPage=1;
		if (curentPage>totalPage) curentPage=totalPage;
		
		int start=(curentPage-1)*limit+1,end=0;
		if(curentPage==totalPage) {
			end=totalData;
		}
		else end=curentPage*limit;
		if(totalData==0) {
			start=0;
			end=0;
		}
		paginates.setCurrentPage(curentPage);
		paginates.setStart(start);
		paginates.setEnd(end);
		return paginates;
	}
}
