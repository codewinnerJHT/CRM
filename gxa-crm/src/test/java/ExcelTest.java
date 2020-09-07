import com.alibaba.excel.EasyExcel;
import com.gxa.dto.ResultDto;
import com.gxa.excel.AdminListener;
import com.gxa.excel.StudentListener;
import com.gxa.mapper.StudnetMapper;
import com.gxa.pojo.Admin;
import com.gxa.pojo.Vo.StudentDownloadVo;
import com.gxa.pojo.Vo.StudentParamVo;
import com.gxa.pojo.Vo.StudentVo;
import com.gxa.service.StudentService;
import com.gxa.service.impl.StudentServiceImpl;
import com.gxa.util.TestFileUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author:IT-CNLM
 * @date:Created at 2020/08/14
 */

public class ExcelTest {


    @Autowired
    private StudnetMapper studnetMapper;


    @Test
    public void test01() {
        String fileName = TestFileUtil.getPath() + File.separator + "test.xlsx";
        System.out.println(fileName);
        EasyExcel.read(fileName, Admin.class, new AdminListener()).sheet().doRead();
    }

    @Test
    public void test02() {
        String fileName = TestFileUtil.getPath() + File.separator + "stu.xlsx";
        System.out.println(fileName);
        EasyExcel.read(fileName, StudentVo.class, new StudentListener()).sheet().doRead();
    }

    @Test
    public void test3() {
        StudentService studentService = new StudentService() {
            @Override
            public ResultDto upload(MultipartFile file) throws IOException {
                return null;
            }

            @Override
            public ResultDto getAllStudent(StudentParamVo studentParamVo) {
                return null;
            }

            @Override
            public ResultDto download() {
                List<StudentDownloadVo> studentDownloadVos = studnetMapper.download();
                String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
                // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
                // 如果这里想使用03 则 传入excelType参数即可
                System.out.println(studentDownloadVos.toString());
                EasyExcel.write(fileName, StudentDownloadVo.class).sheet("模板").doWrite(studentDownloadVos);
                System.out.println("下载完成");
                return new ResultDto(200, "下载成功");
            }

        };
    }
}
