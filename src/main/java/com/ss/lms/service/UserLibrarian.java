package com.ss.lms.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.BookCopyDataAccess;
import com.ss.lms.dao.BookDataAccess;
import com.ss.lms.dao.LibraryBranchDataAccess;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookCopy;
import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.entity.BookCopyCompositeKey;

@Component
public class UserLibrarian {
//
//	private DataAccess<Book> bookDao = null;
//	private DataAccess<LibraryBranch> libraryBranchDao = null;
//	private DataAccess<BookCopy> bookCopyDao = null;
//	
//	public UserLibrarian(BookDataAccess bookDao, LibraryBranchDataAccess libraryBranchDao, BookCopyDataAccess bookCopyDao) {
//		this.bookDao = bookDao;
//		this.libraryBranchDao = libraryBranchDao;
//		this.bookCopyDao = bookCopyDao;
//	}
//	
	@Autowired
	BookDataAccess bookDao;

	@Autowired
	LibraryBranchDataAccess libraryBranchDao;

	@Autowired
	BookCopyDataAccess bookCopyDao;

	
	public void createBookCopy(BookCopy bookCopy) {
		bookCopyDao.save(bookCopy);
	}

	public Iterable<Book> readAllBooks() {
		return bookDao.findAll();
	}
	
	public Optional<Book> readBookById(Integer bookId) {
		return bookDao.findById(bookId);
	}

	public Iterable<Book> readBooksByTitle(String title) {
		ArrayList<Book> allBooks = new ArrayList<Book>();
		Iterable<Book> books = bookDao.findAll();
		books.forEach((book) -> {
									if(book.getTitle().contains(title)) {
										allBooks.add(book);
									}
								});
		return allBooks;
	}

	
	public Optional<LibraryBranch> readLibraryBranchById(Integer branchId) {
		return libraryBranchDao.findById(branchId);
	}

	public Iterable<LibraryBranch> readAllLibraryBranches() {

		return libraryBranchDao.findAll();
	}
	
	public Iterable<LibraryBranch> readAllLibraryBranchesByName(String name){
		System.out.println("\n\nName:" + name);
		ArrayList<LibraryBranch> allBranches = new ArrayList<LibraryBranch>();
		Iterable<LibraryBranch> branches = libraryBranchDao.findAll();
		branches.forEach((branch) -> {
									if(branch.getBranchName().contains(name)) {
										allBranches.add(branch);
									}
								});
		System.out.println("\n\nBranches: " + allBranches);
		return allBranches;
	}
	
	public Iterable<BookCopy> readAllBookCopiesByBranchName(String BranchName){
		System.out.println("\n\nName:" + BranchName);
		ArrayList<BookCopy> allBookCopies = new ArrayList<BookCopy>();
		Iterable<BookCopy> bookCopies = bookCopyDao.findAll();
		bookCopies.forEach((bookCopy) -> {
									if(bookCopy.getBookCopyKey().getBranch().getBranchName().contains(BranchName)) {
										allBookCopies.add(bookCopy);
									}
								});
		System.out.println("\n\nBranches: " + allBookCopies);
		return allBookCopies;
	}
	
	public Iterable<BookCopy> readAllBookCopies() {
		return bookCopyDao.findAll();
	}
	
	public Optional<BookCopy> readBookCopyById(BookCopyCompositeKey bookCopyId) {
		return bookCopyDao.findById(bookCopyId);
	}

	
	public void updateLibraryBranch(LibraryBranch libraryBranch) {
		libraryBranchDao.save(libraryBranch);

	}

	
	public void updateBookCopy(BookCopy bookCopy) {
		bookCopyDao.save(bookCopy);

	}

	
	public void deleteBookCopy(BookCopyCompositeKey bookCopyId) {
		bookCopyDao.deleteById(bookCopyId);

	}

}
