/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.PieceOfNews;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface PieceOfNewsFacadeLocal {

    void create(PieceOfNews pieceOfNews);

    void edit(PieceOfNews pieceOfNews);

    void remove(PieceOfNews pieceOfNews);

    PieceOfNews find(Object id);

    List<PieceOfNews> findAll();

    List<PieceOfNews> findRange(int[] range);

    int count();
    
}
