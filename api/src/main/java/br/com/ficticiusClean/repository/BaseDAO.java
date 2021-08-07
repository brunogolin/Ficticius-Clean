package br.com.ficticiusClean.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ficticiusClean.repository.connection.MakeConn;

@Repository
public class BaseDAO {

	@Autowired
	protected MakeConn db;

}
