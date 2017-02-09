package com.example.component.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.component.entity.Record;
import com.example.component.entity.ReturnedStatus;


/**
 * 
 * @author alex
 * This class created for use different SQL query
 *
 */
@Repository
public class RecordDAO {//implements IRecordService{
	static final String SQL_FOR_SEARCH = "SELECT * FROM title WHERE id=?";
	static final String SQL_FOR_UPDATE = "UPDATE title SET body=? WHERE id=?";
	static final String SQL_FOR_SHOWALL = "SELECT * FROM title LIMIT 3 offset ?";
	static final String SQL_FOR_CREATE = "INSERT INTO title (body) VALUES (?)";
	static final String SQL_FOR_REMOVE = "DELETE FROM title WHERE id=?";
	
	
	ReturnedStatus returnedStatus = new ReturnedStatus();
	static final String RESULT_SUCCESS = "SUCCESS";
	static final String RESULT_ERROR = "ERROR";
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class NewRecord implements RowMapper<Record>
	{
		@Override
		public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
			Record record = new Record();
			record.setId(rs.getInt(1));
			record.setTitle(rs.getString(2));
			
			return record;
		}
	}
	/**
	 * method for search all over the record in database by id
	 * @param id
	 * @return record
	 */

	public Record searchById(int id) {
		Record record = jdbc.queryForObject(SQL_FOR_SEARCH, new NewRecord(), id);
		return record;
	}

	/**
	 * method for update date in database 
	 *@param record
	 */
	
	public void updateRecord(Record record) {
		jdbc.update(SQL_FOR_UPDATE, record.getTitle(), record.getId());
	}
	/**
	 * method for show all records on page in database via List
	 * @param page
	 * @return record
	 */

	public Collection<Record> informationAboutRecord(int page) {
		page *=3;
		List<Record> record = jdbc.query(SQL_FOR_SHOWALL, new NewRecord(), page);
		return record;
	}
	
	/**
	 * method for create record and write in database 
	 * @param record
	 */
	
	public void createRecord(Record record) {
		int choice = jdbc.update(SQL_FOR_CREATE, record.getTitle());
		System.out.println(choice);
		if(choice==1)
		{
			returnedStatus.setStatus(RESULT_SUCCESS);
			returnedStatus.getStatus();
		}
		else
		{
			returnedStatus.setStatus(RESULT_ERROR);
			returnedStatus.getStatus();
		}
	}

	/**
	 *method for remove record in database by id 
	 *@param id
	 */
	
	public void removeRecord(int id) {
		jdbc.update(SQL_FOR_REMOVE, id);
	}

}
