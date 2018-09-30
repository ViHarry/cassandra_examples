package com.cassandra.hotel;

import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;


public class Connector {
	TTransport transport = new TSocket("localhost", 9160);
	
	
	public Cassandra.Client connect() throws TTransportException, TException, InvalidRequestException {
		TFramedTransport tf = new TFramedTransport(transport);
		
		TProtocol protocol = new TBinaryProtocol(tf);
		
		Cassandra.Client client = new Cassandra.Client(protocol);
		
		transport.open();
		client.set_keyspace("");
		
		return null;
	}
}
