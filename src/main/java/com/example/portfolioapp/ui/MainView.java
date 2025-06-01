package com.example.portfolioapp.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.*;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/port")
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
		Anchor vkLink = createHeaderLink("https://vk.com", "VK");
		Anchor telegramLink = createHeaderLink("https://t.me", "Telegram");
		Anchor githubLink = createHeaderLink("https://github.com", "GitHub");

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
				new ProjectCardData("1 лаба", "Какая-та лажа", "https://github.com"),
				new ProjectCardData("2 лаба", "Шлеп", "https://github.com"),
				new ProjectCardData("3 лаба", "Большой русский кот", "https://github.com"),
				new ProjectCardData("40 лаба", "?", "https://github.com")
			)
		));
		tabSheet.add("2 курс", createTabContent(List.of(

		)));
		tabSheet.add("3 курс", createTabContent(List.of(
			new ProjectCardData("Программирование",
				"Лабораторные работы по программированию. Калькулятор, weather API, числа фиббоначи и валюты.",
				"https://github.com/Dirwul/Prog5/tree/main"),
			new ProjectCardData("Основы компьютерной графики",
				"Лабораторные работы за семестр. Отрисовка графики с помощью Java и Drawing и Processing.",
				"https://github.com/Dirwul/DrawingProject")
		)));
		tabSheet.add("4 курс", createTabContent(List.of(

		)));
		tabSheet.add("Свои проекты", createTabContent(List.of(

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
