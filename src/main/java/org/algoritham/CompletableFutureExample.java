package org.algoritham;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

	
	public static void main(String[] args) {
		   CompletableFuture.supplyAsync(() -> "Test Message")
	        .thenAccept(System.out::print);
		   System.out.println();
		   CompletableFuture.supplyAsync(() -> "Test Message")
		   .thenApply(fn -> "its matter " +fn)
		   .thenApply(fn -> "no dude "+ fn)
		   .thenAccept(System.out::println);
	}
}
