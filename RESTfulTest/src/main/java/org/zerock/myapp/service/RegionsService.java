package org.zerock.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.RegionsDTO;
import org.zerock.myapp.mapper.RegionsMapper;

import lombok.Setter;

@Service
public class RegionsService {
	
	@Setter(onMethod_=@Autowired)
	private RegionsMapper mapper;
	
	// 모든 Regions획득
	public List<RegionsDTO> getAllRegions() {
		return mapper.getAllRegions();
	} // getAllRegions

	// 특정 REgion 획득
	public RegionsDTO getRegion(String regions_id) {
		return mapper.getRegion(regions_id);
	} // getRegion

	// Create = 새로운 Regions추가
	public void addRegions(RegionsDTO region) {
		mapper.addRegions(region);
	}  //addRegions

	public void updateRegions(String regions_id, RegionsDTO region) {
		mapper.updateRegions(regions_id, region);
	} // updateRegions

	// Delete = Regions 삭제
	public void deleteRegions(String regions_id) {
		mapper.deleteRegions(regions_id);
	} //deleteRegions
	
} // end class