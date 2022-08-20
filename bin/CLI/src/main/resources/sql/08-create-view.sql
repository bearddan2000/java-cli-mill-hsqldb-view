CREATE VIEW DOG_EXPANDED AS
SELECT d.id, b.breed, c.color
FROM DOG AS d
JOIN BREEDLOOKUP AS b ON b.id = d.breedId
JOIN COLORLOOKUP AS c ON c.id = d.colorId
