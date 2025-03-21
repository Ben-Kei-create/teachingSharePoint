//package com.myapp.teachingSharePoint.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.myapp.teachingSharePoint.controller.HomeController.Resource;
//@Controller
//@RequestMapping("/elementary")
//public class ElementaryController {
//
//	public String List(Model model) {
//        List<Resource> elementaryResources = List.of(
//        		new Resource("算数プリント", "teacherA", "/images/sansu.jpg", 45),
//        		new Resource("ひらがな練習帳", "teacherB", "/images/hiragana.jpg", 30),
//        		new Resource("理科観察ノート", "teacherC", "/images/rika.jpg", 20),
//        		new Resource("社会の地図帳", "teacherD", "/images/chizu.jpg", 15),
//        		new Resource("音楽の楽譜", "teacherE", "/images/gakufu.jpg", 50),
//        		new Resource("図工の作品例", "teacherF", "/images/zukou.jpg", 10),
//        		new Resource("体育の運動メニュー", "teacherG", "/images/taiiku.jpg", 35),
//        		new Resource("家庭科のレシピ集", "teacherH", "/images/kateika.jpg", 25)
//        );
//        model.addAttribute("elementaryResources", elementaryResources);
//        return "elementary"; // `src/main/resources/templates/index.html` を表示	
//        }
//}
