package com.bu.backend;

import java.awt.print.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootApplication(exclude = SpringApplicationAdminJmxAutoConfiguration.class)

//@ComponentScan(basePackages = "com.bu.backend")
public class BackEnd25Application {

	public static void main(String[] args) {
		SpringApplication.run(BackEnd25Application.class, args);
		
		
//		ApplicationContext ctx =
//				new ClassPathXmlApplicationContext("setting.xml");

		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext();

		ctx.register(javaConfig.class);
		ctx.register(WheelConfig.class);

		ctx.refresh();




		Car car = (Car)ctx.getBean("car");		
		
		
//		CarFrame frame = (CarFrame)ctx.getBean("frame");	
//				
//		car.setFrame(frame);
//		
//		GetParse();
	}
	
//	static void GetParse()
//	{
//		String xml = 
//"""			
//<?xml version="1.0" encoding="UTF-8"?>
//<channel>
//<totalCount>322</totalCount>
//<list>
//   <item>
//      <recomNo>20210531163321885100</recomNo>
//      <drCode>425</drCode>
//      <drCodeName></drCodeName>
//      <recomtitle>더 월</recomtitle>
//      <recomauthor>존 란체스터</recomauthor>
//      <recompublisher>서울문화사</recompublisher>
//      <recomcallno>843.6-20-138=2 </recomcallno>
//      <recomisbn>9791164380244</recomisbn>
//      <recomfilepath>http://www.nl.go.kr/afile/fileDownload/GCimn</recomfilepath>
//      <recommokcha>&lt;p&gt;1부 벽 4&lt;/p&gt;
//&lt;p&gt;2부 상대 134&lt;/p&gt;
//&lt;p&gt;3부 바다 198&lt;/p&gt;</recommokcha>
//      <recomcontens>&lt;p class=&#034;0&#034; style=&#034;line-height: 170%; margin-right: 6px; margin-left: 6px;&#034;&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-size: 12pt;&#034;&gt; &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;지구의 이상기후 변화로 인해 해수면은 상승하고 정치적으로 분열된 대격변이라 부르는 사건 이후 한 섬나라의 모든 해안선에는 국경과도 같은 거대한 콘크리트 장벽이 세워진다&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;. &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;장벽을 넘어 육지 안으로 오려는 침입자 &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;&amp;lsquo;&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;상대&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;&amp;rsquo;&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;로부터 벽을 지키는 임무를 수행하게 된 신입 경계병 카바나는 &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;2&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;년간의 임무를 무사히 마친다면 다시 자신의 삶으로 돌아갈 수 있다&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;. &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;하지만 침입자를 막아내지 못하고 임무에 실패한다면 벽 너머 육지가 없는 바다로 추방될 것이다&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;. &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;추위&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;, &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;콘크리트&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;, &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;차가운 두려움 앞에서 그는 무사히 &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;2&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;년을 버틸 수 있을까&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;?&lt;/span&gt;&lt;/p&gt;
//&lt;p class=&#034;0&#034; style=&#034;line-height: 170%; margin-right: 6px; margin-left: 6px;&#034;&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-size: 12pt;&#034;&gt; &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;존 란체스터의 소설 &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;『&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;더 월&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;』&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;은 가까운 미래를 그린 소설이지만 지구온난화로 인한 환경변화&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;, &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;경제 갈등 속 세워진 멕시코&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;-&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;미국 장벽 등 꽤 아픈 현실을 반영하고 있다&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;.&lt;/span&gt;&lt;/p&gt;
//&lt;p class=&#034;0&#034; style=&#034;line-height: 170%; margin-right: 6px; margin-left: 6px;&#034;&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;사회적 갈등만 남은 황폐한 지구에서 미래의 우리들은 어떻게 살아남을 수 있을지&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;, &lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;지금의 우리는 무엇을 해야만 하는지 생각하게 하는 소설이다&lt;/span&gt;&lt;span style=&#034;letter-spacing: -0.1pt; font-family: 나눔고딕; font-size: 12pt;&#034;&gt;.&lt;/span&gt;&lt;span style=&#034;color: rgb(255, 0, 0); letter-spacing: -0.1pt; font-size: 12pt;&#034;&gt; &lt;/span&gt;&lt;/p&gt;</recomcontens>
//      <regdate>2021.05.31</regdate>
//      <controlNo> KMO202031770 </controlNo>
//      <publishYear>2020</publishYear>
//      <recomYear>2021</recomYear>
//      <recomMonth>6</recomMonth>
//      <mokchFilePath>http://mokcha.nl.go.kr/kolis/2020/ KMO202031770 _thumbnail.jpg</mokchFilePath>
//   </item>
//</list>
//</channel>
//""";
//			
//		
//		XmlMapper xmlMapper = new XmlMapper();
//        try {
//        	Recommendation book = xmlMapper.readValue(xml, Recommendation.class);
//        	System.out.println(book.getList().get(0).getDrCode());
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			
//			System.out.println(e.getMessage());
//			
////			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			System.out.println(e.getMessage());
//			
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}
        
//	}

}
