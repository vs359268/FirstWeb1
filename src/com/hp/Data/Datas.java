package com.hp.Data;

public class Datas {
		private String id;
	    private String date_time;
	    private String max_temp;
	    private String min_temp;
		public String getId() {
			return id;
		}
		public  void setId(String id) {
			this.id = id;
		}
		public String getDate_time() {
			return date_time;
		}
		public void setDate_time(String date_time) {
			this.date_time = date_time;
		}
		public String getMax_temp() {
			return max_temp;
		}
		public void setMax_temp(String max_temp) {
			this.max_temp = max_temp;
		}
		public String getMin_temp() {
			return min_temp;
		}
		public void setMin_temp(String min_temp) {
			this.min_temp = min_temp;
		}
		 @Override
		public String toString() {
		     return "Datas [id=" + id + ", date_time=" + date_time + ", max_temp=" + max_temp + ", min_temp=" + min_temp +  "]";
		      }
}
