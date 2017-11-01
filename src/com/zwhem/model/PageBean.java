package com.zwhem.model;

import java.util.List;

/** @pdOid 05b8eb8c-ae92-41d6-9a7e-e52c47003984 */
public class PageBean {
   /** 记录总数
    * 
    * @pdOid 7c796d55-eb50-4afd-8b58-e5b4cb0d2fbb */
   private int all;
   /** 当前页号
    * 
    * @pdOid ec1907d5-16fa-44ee-a52a-673acb6c217d */
   private int curPage = 1;
   /** 总页数
    * 
    * @pdOid 2bde0048-dd46-4190-b403-5dbcc1cb8364 */
   private int pageTotal;
   /** 每页显示的记录数
    * 
    * @pdOid c36da831-ae13-47ff-9092-0688aad4efd1 */
   private int pageCount = 3;
   /** 当前页显示记录的起始位置
    * 
    * @pdOid b636018f-6fd7-4352-9bc2-917ce3cd66eb */
   private int start;
   /** 当前页显示记录的终止位置
    * 
    * @pdOid ba813f5e-7c83-4588-a375-42912a551439 */
   private int end;
   /** 前一页
    * 
    * @pdOid 64b9cda2-85ba-4296-83da-1d1a3463d97c */
   private int pre;
   /** 后一页
    * 
    * @pdOid 697a7f68-0f58-43d1-91f5-5f6a3ddd4cb6 */
   private int next;
   
   /** @pdOid 2a59d9a0-6a5f-4af5-abc7-45917911a9c8 */
   public PageBean() {
   	this.curPage = 1;
   	this.pageCount = 3;
   }
   
   /** @param all 
    * @param curPage 
    * @param pageCount
    * @pdOid 66f4dd26-dc60-4937-afe1-4cf08b0dacc2 */
   public PageBean(int all, int curPage, int pageCount) {
   	this.all = all;//记录总数
   	this.curPage = curPage;//当前页
   	this.pageTotal = (all%pageCount)==0?all/pageCount:(all/pageCount+1);//计算总页数
   	this.pageCount = pageCount;//每页显示记的录数
   	this.start = (curPage-1)*pageCount;//本页起始位置
   	this.end = curPage*pageCount>all?all-1:curPage*pageCount-1;//本页的结束位置
   	if(this.end<0){this.end=0;}
   	this.pre = curPage-1>0?curPage-1:1;
   	//System.out.println("start:"+start);
   	//System.out.println("end:"+end);
   	this.next = curPage+1<pageTotal?curPage+1:pageTotal;
   }
   
   /** @pdOid 78380c4a-b3ab-4564-aa8b-33409e422fb4 */
   public int getAll() {
   	return all;
   }
   
   /** @param all
    * @pdOid 13211a09-02d8-4c69-ad61-dea9c94d815e */
   public void setAll(int all) {
   	this.all = all;
   }
   
   /** @pdOid 1add88f5-9130-489c-8ecc-a364de32f339 */
   public int getCurPage() {
   	return curPage;
   }
   
   /** @param curPage
    * @pdOid d94e1fe4-ceb8-4cd8-be33-93df5607e7bb */
   public void setCurPage(int curPage) {
   	this.curPage = curPage;
   	this.start = (curPage-1)*pageCount;
   	this.end = curPage*pageCount>all?all:curPage*pageCount;
   	this.pre = curPage-1>0?curPage-1:1;
   	this.next = curPage+1<pageTotal?curPage+1:pageTotal;
   }
   
   /** @pdOid 204e7b8a-8d01-4672-843f-fb29ad0afd9a */
   public int getPageTotal() {
   	return pageTotal;
   }
   
   /** @param pageTotal
    * @pdOid cabbfe5c-4409-4034-b1a7-52e7107aa0fe */
   public void setPageTotal(int pageTotal) {
   	this.pageTotal = pageTotal;
   }
   
   /** @pdOid b207a5dc-edcd-4d6b-be32-f8666adcee56 */
   public int getPageCount() {
   	return pageCount;
   }
   
   /** @param pageCount
    * @pdOid 0a864442-45dc-422e-8b92-b12ae844b42b */
   public void setPageCount(int pageCount) {
   	this.pageCount = pageCount;
   }
   
   /** @pdOid 7d9cabde-4d06-4a82-bbea-d958da9c77b9 */
   public int getStart() {
   	return start;
   }
   
   /** @param start
    * @pdOid 401eebab-c1c2-4a5b-a212-5a6b2a9d7db7 */
   public void setStart(int start) {
   	this.start = start;
   }
   
   /** @pdOid cee435cd-44a1-4530-b36b-bbfcec3968d3 */
   public int getEnd() {
   	return end;
   }
   
   /** @param end
    * @pdOid 14132671-f31e-41d1-8917-9e9bb7881c26 */
   public void setEnd(int end) {
   	this.end = end;
   }
   
   /** @pdOid f26fbf11-3b7c-42c2-a5d9-038230b7131b */
   public int getPre() {
   	return pre;
   }
   
   /** @param pre
    * @pdOid 916dc9b1-436b-41fb-ad72-d903fdd2f899 */
   public void setPre(int pre) {
   	this.pre = pre;
   }
   
   /** @pdOid 0a511f64-6975-4103-a2d5-705b5af85003 */
   public int getNext() {
   	return next;
   }
   
   /** @param next
    * @pdOid d7192d06-8c7f-4e2c-9069-3a79ba6d5c0a */
   public void setNext(int next) {
   	this.next = next;
   }

}