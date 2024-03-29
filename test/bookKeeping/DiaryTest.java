package bookKeeping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {

    @Test
    public void testLockDiary() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        diary.unlockDiary("Shop9kicks.");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testUnlockDiary() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        assertTrue(true);
        diary.unlockDiary("Shop9kicks.");
        assertFalse(diary.isLocked());
    }

    @Test
    public void testCreateEntry() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        diary.unlockDiary("SHOP9KICKS");
        diary.createEntry("9KICKS", "Shop 9KICKS");
        assertEquals(0, diary.entries.size());
        diary.createEntry("Cohort 14", "Semicolon");
        assertEquals(0, diary.entries.size());
    }

    @Test
    public void testDeleteEntry() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        diary.unlockDiary("Shop9kicks.");
        diary.createEntry("9KICKS", "Semicolon");
        diary.createEntry("Regnos", "Semicolon");
        diary.deleteEntry(1);
        assertEquals(1, diary.entries.size());
        diary.deleteEntry(2);
             assertEquals(1, diary.entries.size());
    }

    @Test
    public void testFindEntryByID() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        diary.unlockDiary("Shop9kicks.");
        diary.createEntry("9KICKS", "Semicolon");
        diary.createEntry("Regnos", "Semicolon");
        Entry entry = diary.findEntryByID(1);
        assertEquals("9KICKS", entry.getTitle());
        entry = diary.findEntryByID(2);
        assertEquals("Regnos", entry.getTitle());
    }

    @Test
    public void testUpdateEntry() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        diary.unlockDiary("Shop9kicks.");
        diary.createEntry("Regnos", "Semicolon");
        diary.createEntry("Cohort 14", "Semicolon");
        diary.updateEntry(1, "New Regnos", "New Semicolon");
        Entry entry = diary.findEntryByID(1);
        assertEquals("New Regnos", entry.getTitle());
        assertEquals("New Semicolon", entry.getBody());
    }

    @Test
    public void testChangePassword() {
        Diary diary = new Diary("theFolahan", "Shop9kicks.");
        diary.unlockDiary("Shop9kicks.");
        assertEquals("Password changed successfully", diary.changePassword("new password"));
    }
}