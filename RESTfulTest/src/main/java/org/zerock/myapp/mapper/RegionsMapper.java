package org.zerock.myapp.mapper;

import java.util.List;

import org.zerock.myapp.domain.RegionsDTO;

public interface RegionsMapper {


	// R = 모든 Regions 획득
	public List<RegionsDTO> getAllRegions();
	
	// R = 특정 Region 획득
	public RegionsDTO getRegion(String region_id);
	
	// Create = 새로운 Regions 생성
	public void addRegions(RegionsDTO region);
	
	// Update = Regions 수정
	public void updateRegions(String region_id, RegionsDTO region);

	// Delete = Regions 삭제
	public void deleteRegions(String region_id);
	
} // end class
