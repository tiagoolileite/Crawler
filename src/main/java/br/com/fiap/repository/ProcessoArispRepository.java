package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ProcessoArispModel;
import br.com.fiap.service.DBConect;

public class ProcessoArispRepository {
	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rs,rsSeq;
	private String sql,sequence;
	
	
	public ProcessoArispRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public List<ProcessoArispModel> findAll(){
		List<ProcessoArispModel> processos = new ArrayList<ProcessoArispModel>();
		PFRepository pfRepository = new PFRepository();
		sql = "select * from tb_arisp";
		
		try {
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idProcessoArisp = rs.getLong(1);
				String cidade = rs.getString(2);
				String cartorio = rs.getString(3);
				String matricula = rs.getString(4);
				PFJsonModel pf = new PFJsonModel();
				long idPf = rs.getLong(5);
				pf = pfRepository.findById(idPf);
				ProcessoArispModel processo = new ProcessoArispModel(idProcessoArisp,cidade,cartorio,matricula,pf);
				
				processos.add(processo);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os processos\n" + e);
		}
		
		return processos;
	}
	
	public List<ProcessoArispModel> findAllById(PFJsonModel pfJson){
		List<ProcessoArispModel> processos = new ArrayList<ProcessoArispModel>();
		sql = "select * from tb_arisp"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idProcessoArisp = rs.getLong(1);
				String cidade = rs.getString(2);
				String cartorio = rs.getString(3);
				String matricula = rs.getString(4);
				pfJson.setIdPf(rs.getLong(5));
				ProcessoArispModel processo = new ProcessoArispModel(idProcessoArisp,cidade,cartorio,matricula,pfJson);
				
				processos.add(processo);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os processos\n" + e);
		}
		
		return processos;
	}
	
	public void saveAllPf(List<ProcessoArispModel> processos, PFJsonModel pf) {
		sql = "INSERT INTO TB_ARISP (" + 
				"id_processo, " +
				"cidade, " + 
				"cartorio, " + 
				"matricula, " +
				"id_pf) " +  
				"VALUES (?, ?, ?, ?, ?)";
		sequence = "select PROCESSO_SEQ.NEXTVAL from dual";
		try {
			
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			
			for(ProcessoArispModel arisp:processos) {
				rsSeq = q.executeQuery();
				rsSeq.next();
				
				long idProcesso = rsSeq.getLong(1);
				
				p.setLong(1,idProcesso);
				p.setString(2, arisp.getCidade());
				p.setString(3, arisp.getCartorio());
				p.setString(4, arisp.getMatricula());
				p.setLong(5, pf.getIdPf());
				p.execute();

			}
				connection.commit();
				System.out.println("Parece q gravou certinho os processos de pessoa física, espero que sim ;X\n");
			
		}catch (Exception e) {
			System.out.println("Erro pra salvar a lista de processos de pf bixo\n" + e);
		}
	}
	public void saveAllPj(List<ProcessoArispModel> processos, PJJsonModel pj) {
		sql = "INSERT INTO TB_ARISP (" + 
				"id_processo, " +
				"cidade, " + 
				"cartorio, " + 
				"matricula, " +
				"id_pj) " +  
				"VALUES (?, ?, ?, ?, ?)";
		sequence = "select PROCESSO_SEQ.NEXTVAL from dual";
		try {
			
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			
			for(ProcessoArispModel arisp:processos) {
				rsSeq = q.executeQuery();
				rsSeq.next();
				
				long idProcesso = rsSeq.getLong(1);
				
				p.setLong(1,idProcesso);
				p.setString(2, arisp.getCidade());
				p.setString(3, arisp.getCartorio());
				p.setString(4, arisp.getMatricula());
				p.setLong(5, pj.getIdPj());
				p.execute();

			}
				connection.commit();
				System.out.println("Parece q gravou certinho os processos de pj, espero que sim ;X\n");
			
		}catch (Exception e) {
			System.out.println("Erro pra salvar a lista de processos pj bixo\n" + e);
		}
	}

	public List<ProcessoArispModel> findAllByIdPj(PJJsonModel pj) {
		List<ProcessoArispModel> processos = new ArrayList<ProcessoArispModel>();
		sql = "select * from tb_arisp"
				+ " where id_pj = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pj.getIdPj());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idProcessoArisp = rs.getLong(1);
				String cidade = rs.getString(2);
				String cartorio = rs.getString(3);
				String matricula = rs.getString(4);
				pj.setIdPj(rs.getLong(6));
				ProcessoArispModel processo = new ProcessoArispModel(idProcessoArisp,cidade,cartorio,matricula,pj);
				
				processos.add(processo);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os processos\n" + e);
		}
		
		return processos;
	}
}
