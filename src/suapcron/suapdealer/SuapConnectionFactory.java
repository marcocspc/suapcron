/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suapcron.suapdealer;

/**
 *
 * @author marcocspc
 */
public class SuapConnectionFactory {
    
    private static SuapConnection conn;
    
    public static SuapConnection getConnection (String matricula, String senha) throws Exception {
        if (conn == null) {
            conn = new SuapConnection(matricula, senha);
            return conn;
        } else {
            return conn;
        }
    }
}
