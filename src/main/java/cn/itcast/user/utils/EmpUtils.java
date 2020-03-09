package cn.itcast.user.utils;

import cn.itcast.user.pojo.Student;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class EmpUtils {

    public static ResponseEntity<byte[]> exportEmp(List<Student> studentsList) {
        //1.创建一个excel文档
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        //2.创建文档摘要
        hssfWorkbook.createInformationProperties();

        //3.获取并配置文档摘要信息
        DocumentSummaryInformation docInfo = hssfWorkbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("学生疫情防控信息");
        //文档管理员
        docInfo.setManager("wgw");
        //文档版本
        docInfo.setApplicationVersion(1);

        //4.获取文档摘要信息
        SummaryInformation summaryInformation = hssfWorkbook.getSummaryInformation();
        //文档标题
        summaryInformation.setAuthor("学生疫情防控信息");
        //文档创建时间
        summaryInformation.setCreateDateTime(new Date());
        //文档备注
        summaryInformation.setComments("学生疫情防控信息");

        //5.创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = hssfWorkbook.createCellStyle();
        //设置该样式的图案颜色为黄色
//        headerStyle.setFillForegroundColor(IndexedColors.GREEN.index);//设置图案颜色
//        headerStyle.setFillBackgroundColor(IndexedColors.RED.index);//设置图案背景色
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        //设置图案填充的样式
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置日期相关的样式
        HSSFCellStyle dateCellStyle = hssfWorkbook.createCellStyle();
        //这里的m/d/yy 相当于yyyy-MM-dd
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = hssfWorkbook.createSheet("学生疫情防控信息表");
        //设置每一列的宽度
        sheet.setColumnWidth(0,5*256);
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(2,10*256);
        sheet.setColumnWidth(3,5*256);
        sheet.setColumnWidth(4,16*256);
        sheet.setColumnWidth(5,20*256);
        sheet.setColumnWidth(6,10*256);
        sheet.setColumnWidth(7,10*256);
        sheet.setColumnWidth(8,18*256);
        sheet.setColumnWidth(9,12*256);
        sheet.setColumnWidth(10,10*256);
        sheet.setColumnWidth(11,10*256);
        sheet.setColumnWidth(12,10*256);
        sheet.setColumnWidth(13,10*256);
        sheet.setColumnWidth(14,10*256);
        sheet.setColumnWidth(15,10*256);
        sheet.setColumnWidth(16,10*256);
        sheet.setColumnWidth(17,10*256);
        sheet.setColumnWidth(18,10*256);
        sheet.setColumnWidth(19,10*256);

        //6.创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("id");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("学号");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("学院");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("班级");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("填报日期");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("姓名");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("电话");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("所在省");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("所在市");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("所在区");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("是否留校中国学生");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("是否武汉籍学生");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("是否湖北籍学生");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("14天内与武汉疫区人员接触");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("14天内与湖北疫区（不含武汉）人员接触");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("是否在武汉");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("是否在湖北（不含武汉)");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("是否今天返校");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("是否疑似");
        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("是否确诊感染");



        for (int i = 0; i < studentsList.size(); i++) {
            Student student= studentsList.get(i);
            HSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getCode());
            row.createCell(2).setCellValue(student.getCollege());
            row.createCell(3).setCellValue(student.getClasses());
            row.createCell(4).setCellValue(student.getDate());
            row.createCell(5).setCellValue(student.getName());
            row.createCell(6).setCellValue(student.getPhone());
            row.createCell(7).setCellValue(student.getProvince());
            row.createCell(8).setCellValue(student.getCity());
            row.createCell(9).setCellValue(student.getArea());
            row.createCell(10).setCellValue(student.getStayAtSchool());
            row.createCell(11).setCellValue(student.getIfWuhanperson());
            row.createCell(12).setCellValue(student.getIfHubeiperson());
            row.createCell(13).setCellValue(student.getWithWuhanMeet());
            row.createCell(14).setCellValue(student.getWithHubeiMeet());
            row.createCell(15).setCellValue(student.getInWuhan());
            row.createCell(16).setCellValue(student.getInHubei());
            row.createCell(17).setCellValue(student.getBackToSchool());
            row.createCell(18).setCellValue(student.getSuspect());
            row.createCell(19).setCellValue(student.getInfect());
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();

        try {
            //将数据表这几个中文的字转码 防止导出后乱码
            headers.setContentDispositionFormData("attachment",
                    new String("学生疫情防控信息表.xls".getBytes("UTF-8"),"ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            hssfWorkbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(stream.toByteArray(),headers, HttpStatus.CREATED);

    }

}
