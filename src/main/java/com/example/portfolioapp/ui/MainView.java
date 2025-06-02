package com.example.portfolioapp.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.*;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("")
@CssImport("css/styles/shared-styles.css")
public class MainView extends AppLayout {

	public MainView() {
		// Шапка
		HorizontalLayout header = createHeader();
		addToNavbar(header);

		// Основное содержимое
		VerticalLayout mainContent = new VerticalLayout();
		mainContent.add(createAboutSection(), createProjectsSection());

		setContent(mainContent);
	}

	private HorizontalLayout createHeader() {
		HorizontalLayout header = new HorizontalLayout();
		header.addClassName("header");

		// Ссылки
		Anchor portfolioLink = createHeaderLink("/", "Портфолио");
		Anchor vkLink = createHeaderLink("https://vk.com/dirwul", "VK");
		Anchor telegramLink = createHeaderLink("https://t.me/dirwul", "Telegram");
		Anchor githubLink = createHeaderLink("https://github.com/dirwul", "GitHub");

		header.add(portfolioLink, vkLink, telegramLink, githubLink);
		return header;
	}

	private Anchor createHeaderLink(String href, String text) {
		Anchor link = new Anchor(href, text);
		link.setClassName("header-link");
		link.setTarget("_blank");
		return link;
	}

	private Div createAboutSection() {
		Div aboutSection = new Div();
		aboutSection.addClassName("about-section");

		// avatar
		Image profileImage = new Image("/images/ava.jpg", "Фото профиля");
		profileImage.addClassName("profile-image");

		// desc
		Div description = new Div();
		description.addClassName("about-text");
		description.add(new Span("Привет! Это маленькое портфолио с моими проектами " +
			"и небольшой информацией о том, чем я занимаюсь."),
			new Span("В шапке профиля можно найти ссылки на соцсети, а снизу находятся проекты и работы в вузе.")
		);

		// hard skills
		Div skills = new Div();
		skills.addClassName("hard-skills");
		skills.add(new H4("Cтек:"));
		skills.add(new Span("Java, Spring, Postgres, MongoDB, JUnit, Testcontainers, Vaadin, Docker, Kafka, CI/CD"));

		aboutSection.add(profileImage, description, skills);
		return aboutSection;
	}

	private Div createProjectsSection() {
		Div content = new Div();
		content.addClassName("projects-section");
		TabSheet tabSheet = new TabSheet();
		tabSheet.addClassName("tab-sheet");
		tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED);

		// Tabs content & project cards
		tabSheet.add("1 курс", createTabContent(List.of(
				new ProjectCardData(
					"Алгоритмы и решение задач",
					"Курс по алгоритмам и структурам данных, включающий в себя теоретические вебинары и решение практических задач",
					"https://drive.google.com/file/d/17MUzRft4rpS1J1CxCV5VGIhsMafsYqA0/view?usp=sharing"),
				new ProjectCardData("Аналитическая геометрия",
					"Работы по аналитической геометрии",
					"https://drive.google.com/file/d/17MUzRft4rpS1J1CxCV5VGIhsMafsYqA0/view?usp=sharing"),
				new ProjectCardData("Информатика",
					"Работы по информатике, включающие в себя теоретические математические задачи, их разбор и решение с помощью Pascal",
					"https://drive.google.com/drive/folders/1JcjOIgz-EbDXhwQcfs8DOJSM5y5HSEui?usp=sharing"),
				new ProjectCardData(
					"Язык Си",
					"Работы на языке Си, охватывающие базовый синтаксис, указатели и прочие примитивы",
					"https://drive.google.com/drive/folders/1zBQRvWyrDPvGS0_HUPA9PaG_xSNysD_s?usp=sharing"
				),
				new ProjectCardData("Курсовая работа",
					"Вычислительный эксперимент исследования движения электрона/протона в электрическом поле",
					"https://drive.google.com/drive/folders/1unxMob7N-kqDzRTLaQ8MRfpUxvDQ2rMJ?usp=sharing")
			)
		));
		tabSheet.add("2 курс", createTabContent(List.of(
			new ProjectCardData(
				"Основы компьютерной алгебры",
				"Основы компьютерной алгебры, включающие в себя лабораторные работы по предмету и обзор различных инструментов, упрощающих работу инженера",
				"https://drive.google.com/drive/folders/1hYub1YZ3v_vJ4HvKiYVzz5axpX-x2XNW?usp=sharing"
			),
			new ProjectCardData(
				"Базы данных",
				"Курс по базам данных, теории и практике. SQL, PostgreSQL и результаты тестирования",
				"https://github.com/Dirwul/Herzen_University/tree/master/БД"
			),
			new ProjectCardData(
				"Программирование",
				"Работы по программированию, за 2 курс. Веб-сервер, обработка ошибок и базовые понятия Python.",
				"https://drive.google.com/file/d/1lX09d6lFMlR45aGVtb5cc7axg0_SctBl/view?usp=sharing"
			),
			new ProjectCardData(
				"Курсовая работа",
				"Моделирование задач с применением динамического программирования",
				"https://drive.google.com/drive/folders/19C3LWtrOZ4kXb1WIV43Ho2PBUVEJw6dU?usp=sharing"
			)
		)));
		tabSheet.add("3 курс", createTabContent(List.of(
			new ProjectCardData("Программирование 5 семестр",
				"Лабораторные работы по программированию за 5 семестр. Калькулятор, weather API, числа фиббоначи и валюты.",
				"https://github.com/Dirwul/Prog5/tree/main"),
			new ProjectCardData(
				"Программирование 6 семестр",
				"Лабораторные работы по программированию 6 семестр. ООП, sphinx, fastAPI",
				"https://drive.google.com/file/d/1c3cDJjh22qeYuH-0FICnuja23lt_ZH0Q/view?usp=sharing"
			),
			new ProjectCardData("Основы компьютерной графики",
				"Лабораторные работы за семестр. Отрисовка графики с помощью Java, Drawing и Processing.",
				"https://github.com/Dirwul/DrawingProject"),
			new ProjectCardData(
				"Технологии и методы визуализации данных",
				"Основы, методы и технологии визуализации данных, как преподносить и группировать материал для его наиболее корректного и понятного изложения.",
				"https://drive.google.com/drive/folders/1iv0QkalhtNuzj7Tgylcvtj1JYOcoDoHE?usp=sharing"
			),
			new ProjectCardData(
				"Курсовая работа",
				"Исследование статистических данных в корпусной лингвистике с помощью Java",
				"https://drive.google.com/drive/folders/12MtvNr-_2cnhqy76ORqWm69Wpf-YZAGs?usp=sharing"
			)
		)));
		tabSheet.add("4 курс", createTabContent(List.of(
			new ProjectCardData(
				"Программирование",
				"Работы в Jupiter Notebook по ML и применению математики в ML",
				"https://github.com/Dirwul/ml-prog"
			),
			new ProjectCardData(
				"Языки написания спецификаций",
				"Диаграммы PlantUML с применением к программному продукту (ВКР)",
				"https://github.com/Dirwul/PlantUML"
			),
			new ProjectCardData(
				"Курсовая работа",
				"Проектирование и разработка электронного портфолио backend-разработчика с использованием фреймворка Vaadin",
				"https://github.com/Dirwul/PortfolioApp"
			)
		)));
		tabSheet.add("Свои проекты", createTabContent(List.of(
			new ProjectCardData(
				"Бот VK",
				"Бот для автоматического размещения комментариев в VK, сразу после выхода поста",
				"https://github.com/Dirwul/KundelikPrivateBot"
			),
			new ProjectCardData(
				"Phylactery Store",
				"Серверное приложение для создания бэкапов на удаленный сервер. Позволяет пользователю регистрироваться, размечает ему пространство и создает все необходимое в инфраструктуре",
				"https://github.com/Dirwul/Phylactery-Store-Server"
			),
			new ProjectCardData(
				"WR APP",
				"Выполнение тестового задания с обработкой CRUD операций и REST API на Java",
				"https://github.com/Dirwul/wr_app"
			)

		)));

		content.add(tabSheet);
		return content;
	}

	private Div createTabContent(List<ProjectCardData> cards) {
		Div content = new Div();
		content.addClassName("tab-content");
		for (ProjectCardData card : cards) {
			content.add(createProjectCard(card));
		}
		return content;
	}

	private Div createProjectCard(ProjectCardData cardData) {
		// Anchor для всей карточки
		Anchor card = new Anchor(cardData.getProjectLink(), "");
		card.setClassName("project-card-link");
		// карточка
		Div content = new Div();
		content.addClassName("project-card");
		// контент карточки
		content.add(new H5(cardData.getTitle())); // Заголовок
		content.add(new Span(cardData.getDescription())); // Описание
		// заворачиваем
		card.add(content);
		return new Div(card);
	}
}
