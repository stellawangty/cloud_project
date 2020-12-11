package com.hadoop.boxoffice.style;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;

import org.apache.hadoop.io.Text;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ReceiveTable implements Writable,DBWritable{
	  //column1:name  column2:country
    private String name;
    private int num;

    public ReceiveTable(){

    }
//    public ReceiveTable(String name,String country){
//        this.name = name;
//        this.country = country;
//    }
    public ReceiveTable(String name,int country){
        this.name = name;
        this.num = num;
    }
    /**Writable  only serializable and deseiralizable
     *
     * @param out
     * @throws IOException
     */
    public void write(DataOutput out) throws IOException {
        /*1.将this.name以UTF8的编码方式写入到out中[Write a UTF8 encoded string to out]
        2.其实这个效果和out.writeString(this.country)是一样的，只不过是DataOutput类型没有writeString()这个方法�?
        �?以�?�用了Text.writeString(...)这个方法
         */
        Text.writeString(out, this.name);
    }

    public void readFields(DataInput in) throws IOException {
        this.num = in.readInt();
        this.name = in.readUTF();
    }


    /**DBWritable
     * write data to mysql
     * @param statement
     * @throws SQLException
     */
    public void write(PreparedStatement statement) throws SQLException {
        statement.setString(1,this.name);
        statement.setInt(2,this.num);
    }

    /**DBWritable
     * get data from resultset.And set in your fields
     * @param resultSet
     * @throws SQLException
     */
    public void readFields(ResultSet resultSet) throws SQLException {
        this.name = resultSet.getString(1);
        this.num = resultSet.getInt(2);
    }

}
