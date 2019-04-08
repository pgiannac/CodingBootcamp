package com.javatpoint.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.javatpoint.beans.Trainer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TrainerDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(Trainer trainer){
        String sql="insert into trainer(lastName,firstName,assignment) values('"+trainer.getLastName()+"',"+trainer.getFirstName()+",'"+
                trainer.getAssignment()+"')";
        return template.update(sql);
    }
    public int update(Trainer trainer){
        String sql="update trainer set lastName='"+trainer.getLastName()+"', firstName="+trainer.getFirstName()+",assignment='"+trainer.getAssignment()+"' where id="+trainer.getId()+"";
        return template.update(sql);
    }
    public int delete(int id){
        String sql="delete from trainer where id="+id+"";
        return template.update(sql);
    }
    public Trainer getTrainerById(int id){
        String sql="select * from trainer where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Trainer>(Trainer.class));
    }
    public List<Trainer> getTrainers(){
        return template.query("select * from trainer",new RowMapper<Trainer>(){
            public Trainer mapRow(ResultSet rs, int row) throws SQLException {
                Trainer trainer=new Trainer();
                trainer.setId(rs.getInt(1));
                trainer.setLastName(rs.getString(2));
                trainer.setFirstName(rs.getString(3));
                trainer.setAssignment(rs.getString(4));
                return trainer;
            }
        });
    }
}