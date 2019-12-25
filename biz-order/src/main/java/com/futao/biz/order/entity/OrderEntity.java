package com.futao.biz.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "futao_springcloud_biz_order")
@TableName("biz_order")
public class OrderEntity {

    @TableId(value = "id")
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @TableField("amount")
//    @Column
    private Long amount;

//    @Column
    private int status;

    private Timestamp createTime;
    private Timestamp updateTime;
}
