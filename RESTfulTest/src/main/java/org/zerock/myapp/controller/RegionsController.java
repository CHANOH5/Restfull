package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.RegionsDTO;
import org.zerock.myapp.service.RegionsService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RestController
@RequestMapping("/regions")
public class RegionsController {
	
	@Autowired
	private RegionsService service;
	
	@GetMapping("")		// 모든 Regions 조회
	public ResponseEntity<List<RegionsDTO>> getAllRegions() {
		List<RegionsDTO> regions = service.getAllRegions();
		return new ResponseEntity<>(regions, HttpStatus.OK);
	} // getAllRegions
	
	@GetMapping("/{regions_id}")		// 특정 Region 조회
	public ResponseEntity<RegionsDTO> getRegion(@PathVariable("regions_id") String regions_id) {	
		RegionsDTO region = service.getRegion(regions_id);
		if(region != null) {
			return new ResponseEntity<>(region, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} // getRegion
	
	@PostMapping("")		// 새로운 Region 등록
	public ResponseEntity<String> addRegions(@RequestBody RegionsDTO region) {
		service.addRegions(region);
		return new ResponseEntity<>("Region added successfully", HttpStatus.CREATED);
	} //addRegions
	
	@PostMapping("/{region_id}")		// Region 수정
	public ResponseEntity<String> updateRegions(@PathVariable("region_id") String region_id, @RequestBody RegionsDTO region) {
		service.updateRegions(region_id, region);
		return new ResponseEntity<>("Region updated successfully", HttpStatus.OK);
	} // updateRegions
	
	@DeleteMapping("/{region_id}")		// Region 삭제
	public ResponseEntity<String> deleteRegions(@PathVariable("region_id") String region_id) {
		service.deleteRegions(region_id);
		return new ResponseEntity<>("Region deleted successfully", HttpStatus.OK);
	} // deleteRegions

} // end class