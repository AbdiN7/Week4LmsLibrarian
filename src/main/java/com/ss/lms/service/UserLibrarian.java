package com.ss.lms.service;

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

	
	public Optional<LibraryBranch> readLibraryBranchById(Integer branchId) {
		return libraryBranchDao.findById(branchId);
	}

	public Iterable<LibraryBranch> readAllLibraryBranches() {

		return libraryBranchDao.findAll();
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
