package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.component.entity.Record;
import com.example.component.service.RecordDAO;

/**
 * 
 * @author alex
 * class RecordService for interaction with RecordController
 *
 */
@Service
public class RecordService {
	
	/*@Autowired
	private IRecordService iRecordService;*/
	@Autowired
	private RecordDAO recordDAO;
	
	/**
	 * method for create record and write in database 
	 * @param record
	 * 
	 */
	public void createRecord(Record record)
	{
		recordDAO.createRecord(record);
	}
	
	/**
	 * 
	 * @param record
	 * method for update record in database by id 
	 */
	public void updateRecord(Record record)
	{
		recordDAO.updateRecord(record);
	}
	
	/**
	 * method for remove record in database by id 
	 * @param id
	 * 
	 */
	public void removeRecord(int id)
	{
		recordDAO.removeRecord(id);
	}
	
	/**
	 * method for search all over the record in database by id
	 * @param id
	 * @return
	 */
	public Record searchById(int id)
	{
		return recordDAO.searchById(id);
	}
	
	/**
	 * method for show all records on page in database via Collection
	 * @param page
	 * @return
	 */
	public Collection<Record> informationAboutRecord(int page)
	{
		return recordDAO.informationAboutRecord(page);
	}
	
	

}
