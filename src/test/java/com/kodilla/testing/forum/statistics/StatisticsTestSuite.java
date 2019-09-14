package com.kodilla.testing.forum.statistics;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfPostEqualsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            usersNames.add(i, "user" + (i+1));
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getAvgPostPerUser(), 0.01);
        Assert.assertEquals(0, forumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0,forumStatistics.getAvgCommentsPerPost(),0.01);
    }
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfPostsEqualsThousand() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            usersNames.add(i, "User" + (i + 1));
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        //When
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(1000, forumStatistics.getPostsQuantity());
        Assert.assertEquals(2000, forumStatistics.getCommentsQuantity());
        Assert.assertEquals(100, forumStatistics.getUsersQuantity());
        Assert.assertEquals(10, forumStatistics.getAvgPostPerUser(), 0.01);
        Assert.assertEquals(20, forumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(2, forumStatistics.getAvgCommentsPerPost(), 0.01);
    }
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfCommentsEqualsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            usersNames.add(i, "User" + (i + 1));
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0, forumStatistics.getAvgCommentsPerPost(), 0.01);
    }
    @Test
    public void testCalculateAdvStatisticsWhenCommentsLessThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            usersNames.add(i, "User" + (i + 1));
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(200);
        //When
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(2, forumStatistics.getAvgCommentsPerUser(), 0.01);
        Assert.assertEquals(0.2, forumStatistics.getAvgCommentsPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenNumberOfUsersEqualsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        //When
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0, forumStatistics.getUsersQuantity());
        Assert.assertEquals(0, forumStatistics.getAvgPostPerUser(), 0.01);
        Assert.assertEquals(0,forumStatistics.getAvgCommentsPerUser(), 0.01);
    }
}
