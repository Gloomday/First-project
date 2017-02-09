package com.example.component.interfaces;

import java.util.Collection;

import com.example.component.entity.Record;

public interface IRecordService {
	
	/**
	 * method for search all over the record in database by id
	 * @param id
	 * @return
	 */
	public Record searchById(int id);
	
	/**
	 * method for update record in database by id 
	 * @param record
	 */
	public void updateRecord(Record record);
	
	/**
	 * method for create record and write in database 
	 * @param record
	 */
	public void createRecord(Record record);
	
	/**
	 * method for remove record in database by id 
	 * @param id
	 */
	public void removeRecord(int id);
	
	/**
	 * method for show all records on page in database via Cpllection
	 * @param page
	 * @return
	 */
	public Collection<Record> informationAboutRecord(int page);
	

}
