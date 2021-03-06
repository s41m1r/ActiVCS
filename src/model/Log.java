
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

/**
 * Based on a solution by Saimir Bala 
 * Source repository: https://github.com/s41m1r/MiningVCS/tree/VisualizationBranch/MiningSVN
 * Altered the class to conform to the newly created EnrichedChanges
 */
public class Log implements Serializable{

	public static String MODIFIED = "Modified";
	public static String ADDED = "Added";
	public static String DELETED = "Deleted";

	protected Collection<LogEntry> entries;

//	/**
//	 * 
//	 */
//	public Log() {
//	}
//
//	/**
//	 * @param list
//	 */
//	public Log(List<LogEntry> list) {
//		super();
//		this.entries = list;
//	}

	/**
	 * @return all the entries
	 */
	public Collection<LogEntry> getAllEntries(){
		return entries;
	}

	public Collection<String> getAllAuthors(){
		Set<String> authors = new HashSet<String>();
		for (LogEntry logEntry : entries) {
			authors.add(logEntry.getAuthor());
		}
		return authors;
	}

	public Collection<DateTime> getAllDates(){
		Set<DateTime> dates = new HashSet<DateTime>();
		for (LogEntry logEntry : entries) {
			dates.add(logEntry.getDate());
		}
		return dates;
	}

	public Collection<List<ChangeTemplate>> getGroupedChanges(){
		Collection<List<ChangeTemplate>> changes = new ArrayList<List<ChangeTemplate>>();
		for (LogEntry logEntry : entries) {
			changes.add(logEntry.getChangeList());
		}
		return changes;
	}

	public Collection<ChangeTemplate> getAllChanges(){
		ArrayList<ChangeTemplate> changes = new ArrayList<ChangeTemplate>();
		for (LogEntry logEntry : entries) {
			changes.addAll(logEntry.getChangeList());
		}
		return changes;
	}

	public Collection<String> getAllFiles(){
		Set<String> changes = new HashSet<String>();
		for (LogEntry logEntry : entries) {
			for(ChangeTemplate ch : logEntry.getChangeList()){
				changes.add(ch.getPath());
			}
		}
		return changes;
	}

	public int size(){
		return entries.size();
	}

	@Override
	public String toString() {
		return "Log [entries=" + entries + "]";
	}

}
