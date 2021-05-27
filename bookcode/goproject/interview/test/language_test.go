package test

import (
	"fmt"
	"golang.org/x/text/language"
	"testing"
)

func TestLanguage(t *testing.T) {
	chinese := language.Chinese
	japanese := language.Japanese
	parse, err2 := language.Parse("en_GB")
	if err2 != nil {
		fmt.Errorf(err2.Error())
	}
	fmt.Println(parse)
	base, err := language.ParseBase("zh-CN")
	if err != nil {
		fmt.Errorf(err.Error())
	}
	fmt.Println(base)
	fmt.Println(chinese)
	fmt.Println(japanese)
}

// LocaleEnum is Locale enumeration value
type LocaleEnum int

// Locale => java.util.Locale
type Locale struct {
	// ID is used to implement enumeration
	id     LocaleEnum
	Lang   string
	County string
}

var locales []Locale = make([]Locale, 22, 22)

// init java.util.Locale static object
func init() {
	// Useful constant for language.
	var ENGLISH = Locale{
		id:     1,
		Lang:   "en",
		County: "",
	}
	// Useful constant for language.
	var FRENCH = Locale{
		id:     2,
		Lang:   "fr",
		County: "",
	}
	// Useful constant for language.
	var GERMAN = Locale{
		id:     3,
		Lang:   "de",
		County: "",
	}
	// Useful constant for language.
	var ITALIAN = Locale{
		id:     4,
		Lang:   "it",
		County: "",
	}
	// Useful constant for language.
	var JAPANESE = Locale{
		id:     5,
		Lang:   "ja",
		County: "",
	}
	// Useful constant for language.
	var KOREAN = Locale{
		id:     6,
		Lang:   "ko",
		County: "",
	}
	// Useful constant for language.
	var CHINESE = Locale{
		id:     7,
		Lang:   "zh",
		County: "",
	}
	// Useful constant for language.
	var SIMPLIFIED_CHINESE = Locale{
		id:     8,
		Lang:   "zh",
		County: "CN",
	}
	// Useful constant for language.
	var TRADITIONAL_CHINESE = Locale{
		id:     9,
		Lang:   "zh",
		County: "TW",
	}
	// Useful constant for language.
	var FRANCE = Locale{
		id:     10,
		Lang:   "fr",
		County: "FR",
	}
	// Useful constant for language.
	var GERMANY = Locale{
		id:     11,
		Lang:   "de",
		County: "DE",
	}
	// Useful constant for language.
	var ITALY = Locale{
		id:     12,
		Lang:   "it",
		County: "it",
	}
	// Useful constant for language.
	var JAPAN = Locale{
		id:     13,
		Lang:   "ja",
		County: "JP",
	}
	// Useful constant for language.
	var KOREA = Locale{
		id:     14,
		Lang:   "ko",
		County: "KR",
	}
	// Useful constant for language.
	var CHINA = Locale{
		id:     15,
		Lang:   "zh",
		County: "CN",
	}
	// Useful constant for language.
	var PRC = Locale{
		id:     16,
		Lang:   "zh",
		County: "CN",
	}
	// Useful constant for language.
	var TAIWAN = Locale{
		id:     17,
		Lang:   "zh",
		County: "TW",
	}
	// Useful constant for language.
	var UK = Locale{
		id:     18,
		Lang:   "en",
		County: "GB",
	}
	// Useful constant for language.
	var US = Locale{
		id:     19,
		Lang:   "en",
		County: "US",
	}
	// Useful constant for language.
	var CANADA = Locale{
		id:     20,
		Lang:   "en",
		County: "CA",
	}
	// Useful constant for language.
	var CANADA_FRENCH = Locale{
		id:     21,
		Lang:   "fr",
		County: "CA",
	}
	// Useful constant for language.
	var ROOT = Locale{
		id:     22,
		Lang:   "",
		County: "",
	}
	locales = append(locales, ENGLISH, FRENCH, GERMAN, ITALIAN, JAPANESE, KOREAN, CHINESE, SIMPLIFIED_CHINESE, TRADITIONAL_CHINESE, FRANCE,
		GERMANY, ITALY, JAPAN, KOREA, CHINA, PRC, TAIWAN, UK, US, CANADA, CANADA_FRENCH, ROOT)
}

func GetLocale(locale LocaleEnum) Locale {
	// Useful constant for language.
	var ROOT = Locale{
		id:     22,
		Lang:   "",
		County: "",
	}
	for _, l := range locales {
		if locale == l.id {
			return l
		}
	}
	return ROOT
}

func (locale Locale) ToString() string {
	return fmt.Sprintf("%s_%s", locale.Lang, locale.County)
}

type LocaleHandle struct {
	Value string `hessian:"value"`
}

func GetLocaleFromHandler(localeHandler LocaleHandle) Locale {
	// Useful constant for language.
	var ROOT = Locale{
		id:     22,
		Lang:   "",
		County: "",
	}
	for _, l := range locales {
		if localeHandler.Value == l.ToString() {
			return l
		}
	}
	return ROOT
}

const (
	_ LocaleEnum = iota
	ENGLISH
	FRENCH
	GERMAN
	ITALIAN
	JAPANESE
	KOREAN
	CHINESE
	SIMPLIFIED_CHINESE
	TRADITIONAL_CHINESE
	FRANCE
	GERMANY
	ITALY
	JAPAN
	KOREA
	CHINA
	PRC
	TAIWAN
	UK
	US
	CANADA
	CANADA_FRENCH
	ROOT
)

func TestEnum(t *testing.T) {
	china := CHINA
	fmt.Println(GetLocale(china))
	locale := GetLocale(FRENCH)
	fmt.Println(locale)

	handle := LocaleHandle{
		Value: "en_GB",
	}
	handler := GetLocaleFromHandler(handle)
	fmt.Println(handler)
}
