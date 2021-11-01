package com.carlosli.sudoker.sudoku.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

import java.io.Serializable;

/**
 * @author 李健成
 * @date 2021/11/1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sudoku")
public class SudokuDO implements Serializable {

    private static final long serialVersionUID = -7426013115001377348L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String sudoku;

}
