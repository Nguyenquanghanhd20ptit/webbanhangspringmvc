package laptrinh.service;

import org.springframework.stereotype.Service;

import laptrinh.modell.paginates;

public interface Paginates_interface {
	public paginates getInfoPaginates(int totalData,int limit,int curentPage );
}
