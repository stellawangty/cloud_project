package com.hadoop.boxoffice.rate;

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
	  //column1:name  column2:number
    private String name;
    private float number;

    public ReceiveTable(){

    }
//    public ReceiveTable(String name,float number){
//        this.name = name;
//        this.number = number;
//    }
    public ReceiveTable(String name,float number){
        this.name = name;
        this.number = number;
    }
    /**Writable  only serializable and deseiralizable
     *
     * @param out
     * @throws IOException
     */
    public void write(DataOutput out) throws IOException {
        out.writeFloat(this.number);
        /*1.将this.name以UTF8的编码方式写入到out中[Write a UTF8 encoded string to out]
        2.其实这个效果和out.writefloat(this.number)是一样的，只不过是DataOutput类型没有writeString()这个方法�?
        �?以�?�用了Text.writeString(...)这个方法
         */
        Text.writeString(out, this.name);
    }

    public void readFields(DataInput in) throws IOException {
        this.number = in.readFloat();
        this.name = in.readUTF();
    }


    /**DBWritable
     * write data to mysql
     * @param statement
     * @throws SQLException
     */
    public void write(PreparedStatement statement) throws SQLException {
        statement.setString(1,this.name);
        statement.setFloat(2,this.number);
    }

    /**DBWritable
     * get data from resultset.And set in your fields
     * @param resultSet
     * @throws SQLException
     */
    public void readFields(ResultSet resultSet) throws SQLException {
        this.name = resultSet.getString(1);
        this.number = resultSet.getFloat(2);
    }

}
