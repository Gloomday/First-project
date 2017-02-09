package com.example.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.component.entity.Record;
import com.example.component.entity.ReturnedStatus;
import com.example.service.RecordService;

/**
 * controller which work with http protocol 
 * @author alex
 *
 */
@RestController
@RequestMapping("/record")
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	
	//ReturnedStatus returnedStatus = new ReturnedStatus(); 
	
	/**
	 * method for search all over the record in database by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/search/{id}", method = RequestMethod.GET)
	public Record searchById(@PathVariable("id") int id)
	{
		return recordService.searchById(id);
	}
	
	/**
	 * method for create record and write in database 
	 * @param record
	 * @return
	 */
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseBody
	public void createRecord(@RequestBody Record record, HttpServletRequest request, HttpServletResponse responce)
	{
		recordService.createRecord(record);
		/*returnedStatus.setStatus("success");
		return returnedStatus;*/
	}
	
	/**
	 * method for update record in database by id 
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateRecord(@RequestBody Record record)
	{
		this.recordService.updateRecord(record);
		/*returnedStatus.setStatus("success");
		return returnedStatus;*/
	}
	
	/**
	 * method for remove record in database by id 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	public void removeRecord(@PathVariable("id") int id)
	{
		recordService.removeRecord(id);
		/*returnedStatus.setStatus("success");
		return returnedStatus;*/
	}
	
	/**
	 * method for show all records on page in database via Collection
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/information/{page}", method = RequestMethod.GET)
	public Collection<Record> informationAboutRecord(@PathVariable("page") int page) 
	{
		return recordService.informationAboutRecord(page);
	}
	
}
