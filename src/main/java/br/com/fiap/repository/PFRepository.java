package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.List;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.service.DBConect;

public class PFRepository {
	
	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rs,rsSeq;
	private String sql,sequence;
	
	public PFRepository() {
		// TODO Auto-generated constructor stub
		connection = DBConect.getConnection() ;
	}
	
	
	
	public PFJsonModel findById(long idPf) {
		PFJsonModel pf = null;
		sql = "select * from tb_pf where id_pf = ?";
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, idPf);
			rs = p.executeQuery();
			if(rs.next()) {
				String cpf = rs.getString(2);
				String rg = rs.getString(3);
				String nome = rs.getString(4);
				Date dtNascimento = rs.getDate(5);
				Date dtConsulta = rs.getDate(6);
				String status = rs.getString(7);
				String nrProcessoArpensp = rs.getString(8);
				String nrProcessoSiel = rs.getString(9);
				String pisPasep = rs.getString(10);
				String placa = rs.getString(11);
				String matriculaSapSivec = rs.getString(12);
				
				pf = new PFJsonModel(idPf,cpf,rg,nome,dtNascimento,dtConsulta,status,
						nrProcessoArpensp,nrProcessoSiel,pisPasep,placa,matriculaSapSivec);
			}
		}
		catch(SQLException e) {
			System.out.println("erro ao pesquisar a pessoa fisica\n"+e);
		}
		
		return pf;
	}
	
	public void save() {
		sql="insert into tb_pf (id_pf,cpf,rg,nome,dt_nascimento,dt_consulta,status, "
				+ "nr_processo_arpensp,nr_processo_siel,pis_pasep,placa,matricula_sap "
				+ ") values (pf_seq.nextval, '123', '123','teste',TO_DATE('12/11/1999', "
				+ " 'dd/MM/yyyy'),TO_DATE(SYSDATE),'teste','12321','12312312','12312','asda123','2342342')";
	}
	
	public void saveAll(List<PFJsonModel> pessoasF) {
		sql="insert into tb_pf (id_pf,cpf,rg,nome,dt_nascimento,dt_consulta,status, "
				+ "nr_processo_arpensp,nr_processo_siel,pis_pasep,placa,matricula_sap "
				+ ") values (?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, ?)";
		sequence = "select PF_SEQ.NEXTVAL from dual";
		try {
			
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			for(PFJsonModel pf:pessoasF) {
				rsSeq.next();
				long idPf = rsSeq.getLong(1);
				
				java.sql.Date dtNascimentoSql = new java.sql.Date(pf.getDtNascimento().getTime());
				java.sql.Date dtConsultaSql = new java.sql.Date(pf.getDtConsulta().getTime());
				p.setLong(1,idPf);
				p.setString(2, pf.getCpf());
				p.setString(3, pf.getRg());
				p.setString(4, pf.getNome());
				p.setDate(5, dtNascimentoSql);
				p.setDate(6, dtConsultaSql);
				p.setString(7, pf.getStatus());
				p.setString(8, pf.getNrProcessoArpensp());
				p.setString(9, pf.getNrProcessoSiel());
				p.setString(10, pf.getPisPasep());
				p.setString(11, pf.getPlaca());
				p.setString(12, pf.getMatriculaSapSivec());
				p.execute();	
				rsSeq = q.executeQuery();
			}
			connection.commit();
			System.out.println("Parece q gravou certinho a lista de pessoas físicas que veio do Json, espero que sim ;X\n");
		}catch (Exception e) {
				System.out.println("Xii, deu erro pra gravar a lista de pessoas F XO\n" + e);
		}
	}
}
